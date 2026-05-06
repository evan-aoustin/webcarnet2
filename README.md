webcarnet

Serveur web:
sudo systemctl restart tomcat10

Recompiler et redeployer apres modification:
cd /home/evan/sites/webcarnet2 && mvn clean package && sudo cp target/webcarnet-1.0-SNAPSHOT.war /var/lib/tomcat10/webapps/webcarnet.war && sudo systemctl restart tomcat10

URL:
http://127.0.0.1:8081/webcarnet/

MariaDB:
sudo systemctl start mariadb

Base:
127.0.0.1:3306
database: car_net
user: root
password: root

phpMyAdmin:
php -S 127.0.0.1:8082 -t /usr/share/phpmyadmin

URL phpMyAdmin:
http://127.0.0.1:8082

Import SQL:
mysql -u root --password='root' car_net < DB.sql
