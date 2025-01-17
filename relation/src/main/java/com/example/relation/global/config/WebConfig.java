package com.example.relation.global.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Value("${file.dir}")
    private String fileDir;
    // 'fileDir'은 외부 파일이 저장된 디렉터리를 나타내는 변수로,
    // application.properties 또는 application.yml 파일에 정의되어야 합니다.

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 예: application.properties에서 file.dir=/path/to/your/directory
        // 이 변수 값을 기준으로 실제 디렉터리 경로를 설정합니다.

        // 'Paths.get(fileDir)'는 'fileDir' 값을 Path 객체로 변환합니다.
        // 'toAbsolutePath()'는 상대 경로를 절대 경로로 변환합니다.
        // 'toString()'은 Path 객체를 문자열로 변환합니다.
        // 결과적으로, 업로드된 파일이 저장된 디렉터리의 절대 경로가 'uploadPath'에 저장됩니다.
        String uploadPath = Paths.get(fileDir).toAbsolutePath().toString();

        // 'addResourceHandler' 메서드는 특정 URL 패턴에 대해 요청을 처리할 리소스 핸들러를 정의합니다.
        // 여기서 "/images/**"는 클라이언트가 "/images/"로 시작하는 모든 URL 요청을 처리하기 위한 패턴입니다.
        // 예: 클라이언트가 http://localhost:8080/images/example.jpg로 요청하면,
        // 이 요청은 아래 'addResourceLocations'에서 지정된 실제 디렉터리 경로로 매핑됩니다.
        registry.addResourceHandler("/images/**")

                // 'addResourceLocations'는 리소스 핸들러가 실제 파일 시스템의 디렉터리 경로를 매핑하도록 지정합니다.
                // "file:" 접두사는 파일 시스템의 절대 경로를 나타냅니다.
                // 여기서는 'uploadPath'가 가리키는 디렉터리를 "/images/**" 요청의 실제 파일 경로로 설정합니다.
                // 예: /images/example.jpg 요청 -> file:/absolute/path/to/your/directory/example.jpg
                .addResourceLocations("file:" + uploadPath + "/");
    }



}