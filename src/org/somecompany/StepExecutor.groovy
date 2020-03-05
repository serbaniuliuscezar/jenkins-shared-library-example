package org.somecompany

class StepExecutor implements IStepExecutor {
    private steps

    StepExecutor(steps) {
        this.steps = steps
    }

    @Override
    int sh(String command) {
        this.steps.sh returnStatus: true, script: "${command}"
    }

    @Override
    void error(String message) {
        this.steps.error(message)
    }
}
