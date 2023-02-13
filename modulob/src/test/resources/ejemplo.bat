@echo off
setlocal enabledelayedexpansion
for /f "tokens=1-6 delims=:/ " %%a in ('time /t') do (
   set hour=%%a
   set minute=%%b
   set second=%%c
)
set /a second=%second% + 10
if %second% geq 60 (
   set /a second=%second% - 60
   set /a minute=%minute% + 1
)
if %minute% geq 60 (
   set /a minute=%minute% - 60
   set /a hour=%hour% + 1
)
if %hour% geq 24 (
   set hour=0
)
echo %hour%:%minute%:%second% > procesoparalelo.txt
