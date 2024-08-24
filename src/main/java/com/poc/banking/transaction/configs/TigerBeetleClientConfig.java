package com.poc.banking.transaction.configs;

import com.tigerbeetle.Client;
import com.tigerbeetle.UInt128;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;

@Configuration
public class TigerBeetleClientConfig {


    @Value("${tigerbeetle.connection.clusterID:0}")
    private BigInteger clusterID;

    @Value("${tigerbeetle.connection.address:3000}")
    private String[] replicaAddress;

    @Bean
    public Client tigerBeetleClient() {
        return new Client(UInt128.asBytes(clusterID), replicaAddress);
    }


}
