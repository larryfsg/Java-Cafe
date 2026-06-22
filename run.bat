@echo off
setlocal

REM move to project root (pasta onde estÃ¡ o .bat)
cd /d %~dp0

echo Cleaning old classes...
del /s /q *.class >nul 2>&1

echo Creating bin folder...
if not exist bin mkdir bin
if not exist bin\view mkdir bin\view

echo Compiling project...
javac -cp "lib/flatlaf-3.7.1.jar" -d bin ^
src\Main.java ^
src\controller\InventoryController.java ^
src\controller\MenuController.java ^
src\controller\NavegationListener.java ^
src\controller\OrderController.java ^
src\controller\SalesSummaryListener.java ^
src\model\Coffee.java ^
src\model\Inventory.java ^
src\model\Order.java ^
src\model\OutOfStockException.java ^
src\persistence\InventoryCSVLoader.java ^
src\persistence\InventoryCSVSaver.java ^
src\persistence\SalesReportReader.java ^
src\persistence\SalesReportUpdater.java ^
src\view\CoffeeButton.java ^
src\view\CoffeeStockButton.java ^
src\view\Header.java ^
src\view\InventoryScreen.java ^
src\view\JavaCafeGUI.java ^
src\view\Menu.java ^
src\view\OrderEntryScreen.java ^
src\view\OrderJPanel.java ^
src\view\PickSize.java ^
src\view\ReceiptJDialog.java ^
src\view\SalesSummaryDialog.java ^
src\view\ShoppingCart.java ^
src\view\UpdateStockDialog.java ^
src\view\WrapLayout.java

if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b
)

echo Copying images...
xcopy /E /I /Y src\view\images bin\view\images >nul

echo Running program...
start "" javaw -cp "lib/flatlaf-3.7.1.jar;bin" Main

exit
