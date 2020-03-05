package org.somecompany.build;

import org.somecompany.IStepExecutor;
import org.somecompany.ioc.ContextRegistry;
import org.somecompany.ioc.IContext;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Example test class
 */
public class MsBuildTest {
    private IContext _context;
    private IStepExecutor steps;

    @Before
    public void setup() {
        _context = mock(IContext.class);
        steps = mock(IStepExecutor.class);

        when(_context.getStepExecutor()).thenReturn(steps);

        ContextRegistry.registerContext(_context);
    }

    @Test
    public void build_callsShStep() {
        // prepare
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(solutionPath);

        // execute
        builder.build();

        // verify
        verify(steps).sh(anyString());
    }

    @Test
    public void build_shStepReturnsStatusNotEqualsZero_callsErrorStep() {
        // prepare
        String solutionPath = "some/path/to.sln";
        MsBuild builder = new MsBuild(solutionPath);

        when(steps.sh(anyString())).thenReturn(-1);

        // execute
        builder.build();

        // verify
        verify(steps).error(anyString());
    }
}
