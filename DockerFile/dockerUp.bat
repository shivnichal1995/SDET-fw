@echo off
cd /d %~dp0

echo Cleaning old containers...

docker compose down

echo Removing existing selenium-hub if present...
docker rm -f selenium-hub 2>nul

echo Starting Grid...
docker compose -f docker-compose.yml up > output.txt 2>&1

echo Grid started at http://localhost:4444