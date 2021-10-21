# Hello world

According with [https://www.rabbitmq.com/tutorials/tutorial-one-java.html](https://www.rabbitmq.com/tutorials/tutorial-one-java.html).

## Run it

Use this command to run with docker:
```bash
docker container run -d --name rabbitmq -p 5672:5672 -p 15672:15672 -v rabbitmq_data:/var/lib/rabbitmq rabbitmq:3.9-management
```

the host rabbitmq.local is set in `/etc/hosts`

use pair `127.0.0.1  rabbitmq.local` to setup host.

To access the host [http://rabbitmq.local:15672](http://rabbitmq.local:15672) using guest, guest as user and password, respectively.

## Example


