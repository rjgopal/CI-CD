FROM maven:3.8.3-openjdk-17-slim
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
COPY src/test/resources/FeatureFiles .src/test/resources/FeatureFiles
# Install Chrome and related dependencies
RUN apt-get update && apt-get install -y curl unzip xvfb libxi6 libgconf-2-4 gnupg2
# Download and install Chrome
RUN curl -sS -o - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add
RUN echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
RUN apt-get -y update
RUN apt-get -y install google-chrome-stable
ENV CHROME_BIN=/usr/bin/google-chrome-stable
ENV CHROME_PATH=/usr/bin/google-chrome-stable
ENV CHROME_DRIVER=/usr/bin/chromedriver
#ENV CHROME_DRIVER_VERSION=$(google-chrome-stable --version | sed -E 's/[^0-9]+([0-9]+)\..*/\1/')
ENV DISPLAY=:99
# Download and install ChromeDriver
RUN wget -qO- "https://chromedriver.storage.googleapis.com/114.0.5735.16/chromedriver_linux64.zip" | zcat > /usr/local/bin/chromedriver
RUN chmod +x /usr/local/bin/chromedriver
RUN mvn clean install
CMD Xvfb :99 -screen 0 1024x768x24 -ac +extension RANDR && mvn test
