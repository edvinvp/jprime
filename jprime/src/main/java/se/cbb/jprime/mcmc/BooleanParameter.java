package se.cbb.jprime.mcmc;

import se.cbb.jprime.io.SampleBoolean;

/**
 * Holds a boolean state parameter.
 * 
 * @author Joel Sjöstrand.
 */
public class BooleanParameter implements StateParameter {

	/** Name. */
	protected String name;
	
	/** Current state. */
	protected boolean value;
	
	/** Cache. */
	protected Boolean cache;
	
	/**
	 * Constructor.
	 * @param name parameter's name.
	 * @param initVal initial value.
	 */
	public BooleanParameter(String name, boolean initVal) {
		this.name = name;
		this.value = initVal;
		this.cache = null;
	}

	/**
	 * Caches the current value. May e.g. be used by a <code>Proposer</code>.
	 */
	public void cache() {
		this.cache = new Boolean(this.value);
	}

	/**
	 * Clears the cached value. May e.g. be used by a <code>Proposer</code>.
	 */
	public void clearCache() {
		this.cache = null;
	}

	/**
	 * Replaces the current value with the cached value, and clears the latter.
	 * May e.g. be used by a <code>Proposer</code>.
	 */
	public void restoreCache() {
		this.value = this.cache.booleanValue();
		this.cache = null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getNoOfSubParameters() {
		return 1;
	}

	@Override
	public String getSampleHeader() {
		return this.name;
	}

	@Override
	public String getSampleValue() {
		return SampleBoolean.toString(this.value);
	}

	@Override
	public Class<?> getSampleType() {
		return SampleBoolean.class;
	}

}
