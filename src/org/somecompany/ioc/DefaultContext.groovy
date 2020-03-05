package org.somecompany.ioc

import org.somecompany.IStepExecutor
import org.somecompany.StepExecutor

class DefaultContext implements IContext, Serializable {
    private steps

    DefaultContext(steps) {
        this.steps = steps
    }

    @Override
    IStepExecutor getStepExecutor() {
        return new StepExecutor(this.steps)
    }
}
