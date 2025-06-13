package com.io.tusexample

import me.desair.tus.server.TusFileUploadService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File

@Configuration
class TasConfig {

    @Bean
    fun tusFileUploadService(): TusFileUploadService {
        val uploadDir = File("uploads")
        if(!uploadDir.exists()) {
            uploadDir.mkdirs()
        }

        return TusFileUploadService()
            .withStoragePath("uploads")

    }
}