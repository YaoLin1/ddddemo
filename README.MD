
## 快速开始

### 1
git clone <工程地址>  

### 2
编译环境要求JKD8+，maven3

mvn clean package -DskipTests=true

### 3
导入idea或eclipse

### 4
初始化数据库，采用mysql

在test库中执行customer表创建的脚本

ddddemo/ddddemo-infrastructure/src/main/resources/customer.sql

修改jdbc连接参数


ddddemo/ddddemo-app/src/main/resources/app-infrastructure.properties

````
mysql.jdbc.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&allowMultiQueries=true

mysql.jdbc.username=root

mysql.jdbc.password=123456
````

### 5
启动类在start模块的
org.cliff.ddd.demo.Application类


### 6
应用启动后访问测试地址

新增一个客户（随机生成）：

http://localhost:8080/test/add 

````
{"errCode":null,"errMessage":null,"success":true}
````

查询客户列表：

http://localhost:8080/test/list 

````
{"errCode":null,"errMessage":null,"total":5,"data":[{"extValues":{},"customerId":"832802","memberId":null,"customerName":null,"customerType":null,"companyName":"杭州XX公司","source":null},{"extValues":{},"customerId":"836874","memberId":null,"customerName":null,"customerType":null,"companyName":"杭州XX公司","source":null},{"extValues":{},"customerId":"838993","memberId":null,"customerName":null,"customerType":null,"companyName":"杭州XX公司","source":null},{"extValues":{},"customerId":"871459","memberId":null,"customerName":null,"customerType":null,"companyName":"杭州XX公司","source":null},{"extValues":{},"customerId":"89538","memberId":null,"customerName":null,"customerType":null,"companyName":"杭州XX公司","source":null}],"success":true}
````

## PS.按照脚手架生成sofa应用框架

mvn archetype:generate  -DgroupId=org.cliff -DartifactId=ddddemo -Dversion=1.0.0-SNAPSHOT -Dpackage=org.cliff.ddd.demo -DarchetypeArtifactId=sofa-framework-archetype -DarchetypeGroupId=com.alibaba.sofa -DarchetypeVersion=1.0.0-SNAPSHOT


主要工作是在脚手架的基础上，加入web功能和mysql连接