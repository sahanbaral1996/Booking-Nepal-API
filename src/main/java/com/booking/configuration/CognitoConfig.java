package com.booking.configuration;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CognitoConfig {

    @Value("${aws.cognito.user.accessToken}")
    private String AWS_ACCESS_TOKEN;

    @Value("${aws.cognito.user.SecretKey}")
    private String AWS_CLIENT_TOKEN;
    @Bean
    public AWSCognitoIdentityProvider getCognitoClient(){
        BasicAWSCredentials cred = new BasicAWSCredentials(AWS_ACCESS_TOKEN,AWS_CLIENT_TOKEN);
        AWSCredentialsProvider provider =  new AWSStaticCredentialsProvider(cred);
        return AWSCognitoIdentityProviderClient.builder().standard().withCredentials(provider).withRegion(Regions.AP_SOUTH_1).build();
    }
}
