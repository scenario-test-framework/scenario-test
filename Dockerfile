# scenario-test-framework
#---------------------------------------------------------------------

FROM openjdk:8-jdk

RUN apt-get update -y
RUN apt-get install -y             \
    curl                           \
    xvfb                           \
    maven                          \
    git
RUN curl -o ~/google-chrome-stable_current_amd64.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt install -y ~/google-chrome-stable_current_amd64.deb 
RUN apt-get clean               && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p ~/scenario-test

COPY . /root/scenario-test

RUN cd ~/scenario-test && \
    mvn test-compile

CMD export DISPLAY=:99 && \
    ( Xvfb :99 & ) && \
    cd ~/scenario-test && \
    mvn clean test


