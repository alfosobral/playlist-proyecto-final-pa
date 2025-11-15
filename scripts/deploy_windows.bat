@echo off
echo ===============================
echo Desplegando Mi Playlist
echo ===============================
cd %~dp0\..
for %%f in (target\*.jar) do (
    echo Ejecutando %%f ...
    java -jar "%%f"
)
