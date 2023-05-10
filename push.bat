@echo off
title made by @NK203 !!!
echo "===================== From NK203 with love <3 =====================
echo .
taskkill /F /IM git.exe
echo .
echo push code hay pull code ?
set /p pullorpush= push nhap 1 - pull nhap 2 :
if(%pullorpush%==1)(git pull close) 
if(%pullorpush%==2)(echo Start to upload file
git add --all
set /p input= Nhap nhung gi thay doi (khong biet thi enter) : 
git diff-index --quiet HEAD ||git commit -m "%input% on %DATE%"
git push
) 
pause