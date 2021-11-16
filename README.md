# Getting Started

App deployed into AWS:  http://airxeleratetestapp-env-1.eba-7zepmgtm.eu-central-1.elasticbeanstalk.com 

Prepared postman collection: <b>AirxelerateTestApp.postman_collection.json</b>
which calls AWS instance. Located in main directory.

Also you can test app locally, you just need to change profile from <b>prod</b> to <b>aws</b>. It will connect to DB instance on the AWS side.

I added support only for two types of roles: ADMIN, READ_ONLY

Main user with role ADMIN is:
<br>
username: <b>airxelerate</b><br>
password: <b>not.safe</b>

User with role READ_ONLY is:
<br>
username: <b>client</b><br>
password: <b>1111</b>
