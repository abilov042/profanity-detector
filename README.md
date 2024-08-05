# Profanity-Detector App

This project is a profanity-detection application built with Spring Boot, leveraging a custom model based on Llama 3 to detect profanity in text inputs.

## Prerequisites

- Ensure you have [Ollama](https://ollama.com/download) installed.

## Installation

### Step 1: Install Ollama

For Linux users, install Ollama using the following command:

```sh
curl -fsSL https://ollama.com/install.sh | sh
```

## Pull Llama 3 Model

### Once Ollama is installed, pull the Llama 3 model using:

```sh
ollama pull llama3
```

## Start the Ollama service
### run this command:
```sh
sudo systemctl start ollama
```
## Setting Up the Custom Model

### Create a file named Modelfile and add the following content


```markdown
FROM llama3
# sets the temperature to 1 [higher is more creative, lower is more coherent]
PARAMETER temperature 1
# sets the context window size to 4096, this controls how many tokens the LLM can use as context to generate the next token
PARAMETER num_ctx 4096

# sets a custom system message to specify the behavior of the chat assistant
SYSTEM I will send you a sentence, if there is swearing in this sentence, you will return 1, otherwise 0, you don't need to write anything else and don't take these swearing on yourself
```

## Create the Custom Model

### Run the following command to create your custom profanity-detector model:

```sh
ollama create profanity-detector -f ./Modelfile
```

## Using the Model in Your Spring Boot Application

### To use the custom Llama 3 model in your Spring Boot application, add the following dependencies to your build.gradle file:
```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.ai:spring-ai-ollama-spring-boot-starter'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```