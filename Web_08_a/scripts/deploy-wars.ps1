# Script copy WAR từ folder dist/ sang Tomcat webapps
# Usage: set environment variable CATALINA_HOME (path Tomcat) then run

if (-not $env:CATALINA_HOME) {
    Write-Host "ERROR: CATALINA_HOME is not set. Please set CATALINA_HOME to your Tomcat installation folder." -ForegroundColor Red
    exit 1
}

$distDir = Join-Path (Get-Location) "dist"
if (-not (Test-Path $distDir)) {
    Write-Host "ERROR: dist/ not found. Build the project first with 'ant'." -ForegroundColor Red
    exit 1
}

$war = Get-ChildItem -Path $distDir -Filter "*.war" | Select-Object -First 1
if (-not $war) {
    Write-Host "ERROR: No WAR found in dist/. Run 'ant' to build the WAR." -ForegroundColor Red
    exit 1
}

$dest = Join-Path $env:CATALINA_HOME "webapps"
Copy-Item $war.FullName -Destination $dest -Force
Write-Host "Copied $($war.Name) to $dest" -ForegroundColor Green
Write-Host "You can start Tomcat with the 'Start Tomcat' task or run $env:CATALINA_HOME\bin\startup.bat" -ForegroundColor Yellow
