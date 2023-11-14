package hello.config;

import hello.datasource.MyDataSource;
import hello.datasource.MyDataSourcePropertiesV1;
import hello.datasource.MyDataSourcePropertiesV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties(MyDataSourcePropertiesV2.class)
@RequiredArgsConstructor
public class MyDataSourceConfigV2 {

    private final MyDataSourcePropertiesV1 myDataSourcePropertiesV1;

    @Bean
    public MyDataSource dataSource(){
        return new MyDataSource(myDataSourcePropertiesV1.getUrl(), myDataSourcePropertiesV1.getUsername(), myDataSourcePropertiesV1.getPassword(), myDataSourcePropertiesV1.getEtc().getMaxConnection(),myDataSourcePropertiesV1.getEtc().getTimeout(),myDataSourcePropertiesV1.getEtc().getOptions());
    }
}
