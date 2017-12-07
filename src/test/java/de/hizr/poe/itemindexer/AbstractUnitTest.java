package de.hizr.poe.itemindexer;

import static org.mockito.MockitoAnnotations.initMocks;

import org.testng.annotations.BeforeMethod;

/**
 * @author hizr
 */
public abstract class AbstractUnitTest {

	@BeforeMethod(alwaysRun = true)
	public void injectMock() {
		initMocks(this);
	}

}
