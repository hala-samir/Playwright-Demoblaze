FROM mcr.microsoft.com/playwright:v1.38.0-jammy

# Install dependencies
RUN apt-get update && apt-get install -y wget curl

# Install Java 17 (it may already be present in the image)
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Set JAVA_HOME (if needed)
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y maven

COPY ./ ./PlaywrightPageObjectModel
WORKDIR PlaywrightPageObjectModel