# Java-Cafe ☕
A POS system for a coffee shop developed for Object-Oriented Programming course, based on the MVC architecture and OOP principles.<br><br>

## ꩜ The application
* The application manages orders and tracks inventory. To ensure data persistence, it records inventory levels and sales in local files during runtime. The recorded data is also loaded into the system every time it runs.<br><br>
* The system also provides a clean GUI with two distinct screens that allows the user to **process transactions** and **monitor and update stock levels**. <br><br>

## ꩜ Data Persistence
The application loads data at startup, and saves it whenever its necessary. The data files and their respective fields are listed below:<br><br>
* **coffees.csv** <br>
Coffee Name, Ingredients, Small Stock, Medium Stock, Large Stock, Small Price, Medium Price, Large Price<br><br>
* **sales.csv** <br>
Quantity, Coffee Name, Size, Unitary Price, Total Price<br><br>

## ꩜ Dependencies
This project uses:
* FlatLaf (modern look and feel for Swing)
  * JAR file included in lib/flatlaf-3.7.1.jar <br><br>

## ꩜ How to run it

**Required:**<br>

* Java Development Kit (JDK) 8+ or superior<br>

**Clone the repository with:**<br>
```
git clone https://github.com/larryfsg/Java-Cafe
```

<br>**[WINDOWS]<br> Option A:** Using run.bat file<br>
* Start the application running the provided run.bat file

<br>**[LINUX]<br> Option A:** Using run.sh file<br>
```
chmod +x run.sh
./run.sh
```

<br> **Option B:** Compile and run from the project root directory<br>
```
javac -cp "lib/flatlaf-3.7.1.jar" -d bin $(find src -name "*.java")
cp -r src/view/images bin/view/
java -cp "lib/flatlaf-3.7.1.jar:bin" Main
```

## ꩜ Pictures
Order entry screen <br>
<table>
  <tr>
    <!-- Left Column: Big Image spanning 2 rows -->
    <td rowspan="2" align="center" valign="middle">
      <img width="650" alt="Order entry screen" src="https://github.com/user-attachments/assets/47b41fe6-f780-435c-8bea-860229e2f2e0" />
    </td>
    <!-- Right Column, Row 1: First Small Image -->
    <td align="center" valign="middle">
      <img width="350" alt="Adding order to cart" src="https://github.com/user-attachments/assets/8b300dc9-d913-44f1-8d21-1e62d44a843a" />
    </td>
  </tr>
  <tr>
    <!-- Right Column, Row 2: Second Small Image -->
    <td align="center" valign="middle">
      <img width="350" alt="Displaying order receipt" src="https://github.com/user-attachments/assets/3d4a9f4f-a5da-4550-9c9f-1264f082f590" />
    </td>
  </tr>
</table>
<br>
Inventory screen and sales summary <br>
<table>
  <tr>
    <!-- Left Column: Big Image spanning 2 rows -->
    <td rowspan="2" align="center" valign="middle">
      <img width="650" alt="Order entry screen" src="https://github.com/user-attachments/assets/6ca205c5-ec22-4143-bac0-21c142cdabcc" />
    </td>
    <!-- Right Column, Row 1: First Small Image -->
    <td align="center" valign="middle">
      <img width="350" alt="Adding order to cart" src="https://github.com/user-attachments/assets/e118144c-3359-409a-bc81-bbd24325886d" />
    </td>
  </tr>
  <tr>
    <!-- Right Column, Row 2: Second Small Image -->
    <td align="center" valign="middle">
      <img width="350" alt="Displaying order receipt" src="https://github.com/user-attachments/assets/ca33ad9e-36b9-4196-887a-17fcd5c88a38" />
    </td>
  </tr>
</table>

## ꩜ Developers
 ✿ [Larry Felipe](https://github.com/larryfsg/) <br>
 NUSP: 16966460
 ✿ [Sarah Meicy](https://github.com/sarehicy) 
 NUSP: 16830357
