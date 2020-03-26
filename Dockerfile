FROM openjdk:11

RUN apt-get update; apt-get install nano

WORKDIR /opt
RUN wget --content-disposition https://app.overops.com/app/download?t=sa-tgz
RUN tar xvzf takipi-agent-*.tar.gz
RUN rm takipi-agent-*.tar.gz

WORKDIR /opt/takipi/
COPY agent.properties .

WORKDIR /opt/ShoppingCart

COPY . .

RUN mv .m2/ ~/.

# to build, run:
# docker run -it container bash
# ./mvnw -Dsonar.login=LOGIN -Dsonar.password=PASS test sonar:sonar
