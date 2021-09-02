@echo off

set DEBUG_MODE=

if "%1" == "debug" (
  set DEBUG_MODE=debug
)

cd com.ingeint.scaleconnector.targetplatform
call .\plugin-builder.bat %DEBUG_MODE% ..\com.ingeint.scaleconnector ..\com.ingeint.scaleconnector.test
cd ..
