package com.boclips.lti.configuration

import org.imsglobal.aspect.LtiKeySecretService
import org.imsglobal.aspect.LtiLaunchVerifier
import org.imsglobal.lti.launch.LtiOauthVerifier
import org.imsglobal.lti.launch.LtiVerifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@Configuration
@EnableAspectJAutoProxy
class LtiContext {
    @Bean
    fun ltiVerifier(): LtiVerifier {
        return LtiOauthVerifier()
    }

    @Bean
    fun ltiAspect(ltiKeyService: LtiKeySecretService, ltiVerifier: LtiVerifier): LtiLaunchVerifier {
        return LtiLaunchVerifier(ltiKeyService, ltiVerifier)
    }
}
