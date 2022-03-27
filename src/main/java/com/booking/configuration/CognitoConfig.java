package com.booking.configuration;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CognitoConfig {
    @Bean
    public AWSCognitoIdentityProvider getCognitoClient(){
        BasicAWSCredentials cred = new BasicAWSCredentials("AKIA5X3F76YEGFBGWX4O","ZQ48KmroSNpVKbbq91Z05tDeL5FzB+tItTx2mNi0");
        AWSCredentialsProvider provider =  new AWSStaticCredentialsProvider(cred);
        return AWSCognitoIdentityProviderClient.builder().standard().withCredentials(provider).withRegion(Regions.AP_SOUTH_1).build();
    }
}
