package com.io.tusexample

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import me.desair.tus.server.TusFileUploadService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.io.IOException

@RestController
@RequestMapping("/")
class TusUploadController(
    private val tusFileUploadService: TusFileUploadService
) {

    @RequestMapping(
        method = [RequestMethod.POST, RequestMethod.PATCH, RequestMethod.HEAD, RequestMethod.OPTIONS],
        value = ["/**"]
    )
    @Throws(IOException::class)
    fun tusUpload(request: HttpServletRequest, response: HttpServletResponse) {
        tusFileUploadService.process(request, response)
    }
}