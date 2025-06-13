package com.io.tusexample

import me.desair.tus.server.TusFileUploadService
import jakarta.servlet.*
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component


@Component
class TusFilter(
    private val tusFileUploadService: TusFileUploadService
) : Filter {

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, chain: FilterChain) {
        val req = servletRequest as HttpServletRequest
        val res = servletResponse as HttpServletResponse

        if (req.requestURI.startsWith("/")) {
            tusFileUploadService.process(req, res)
            if (res.status != 0) {
                return
            }
        }
        chain.doFilter(req, res)
    }

    override fun init(filterConfig: FilterConfig?) {}
    override fun destroy() {}
}