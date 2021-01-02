package com.cmbytes.compose.testing.general.rules

import io.mockk.MockKAnnotations
import org.junit.rules.MethodRule
import org.junit.runners.model.FrameworkMethod
import org.junit.runners.model.Statement

class MockKRule : MethodRule {
    override fun apply(base: Statement, method: FrameworkMethod, target: Any): Statement {
        return object : Statement() {
            override fun evaluate() {
                MockKAnnotations.init(target)
                base.evaluate()
            }
        }
    }
}