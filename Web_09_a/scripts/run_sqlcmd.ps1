param(
    [string]$server = "localhost",
    [string]$username = "sa",
    [string]$password = "12345",
    [string]$file = ".\sql\init_db.sql"
)

if (-not (Get-Command sqlcmd -ErrorAction SilentlyContinue)) {
    Write-Host "'sqlcmd' not found. Install SQL Server Client Tools (sqlcmd) or run the SQL manually in SSMS." -ForegroundColor Yellow
    exit 1
}

sqlcmd -S $server -U $username -P $password -i $file
Write-Host "Executed $file" -ForegroundColor Green
