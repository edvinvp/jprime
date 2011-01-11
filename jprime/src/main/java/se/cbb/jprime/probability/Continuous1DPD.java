package se.cbb.jprime.probability;

import se.cbb.jprime.math.RealInterval;

/**
 * Interface for 1-D continuous probability distributions, i.e. acting on real numbers. 
 * Examples include the gamma and exponential distributions.
 * <p/>
 * "Continuous" is here used in the sense distinguishing it from discrete distributions.
 * It is thus perfectly allowed to have an implementation which is piecewise continuous, e.g.
 * resembling a histogram. We do, however, require that all implementations are defined
 * for a single domain interval [a,b], (a,b], [a,b) or (a,b), where the bounds a&lt;b may take on
 * real numbers as well as negative and positive infinity.
 * 
 * @author Joel Sjöstrand.
 */
public interface Continuous1DPD extends ProbabilityDistribution {
	
	/**
	 * Returns the probability density function f(x) for
	 * a specified value x.
	 * @param x the value where to evaluate density.
	 * @return the probability density, f(x).
	 */
	public double getPDF(double x);

	/**
	 * Returns cumulative density function F(x)=P(X<=x) for a
	 * specified value x.
	 * @param x the value where to evaluate the cumulative density.
	 * @return the cumulative density F(x).
	 */
	public double getCDF(double x);
	
	/**
	 * For specified values a<=b, returns the probability F(b)-F(a)=P(a<=X<=b).
	 * Should a>b, F(a)-F(b) is returned instead.
	 * @param a the smaller boundary.
	 * @param b the larger boundary.
	 * @return P(a<=X<=b).
	 */
	public double getProbability(double a, double b);
	
	/**
	 * Returns the mean, i.e. the expected value mu=E(X).
	 * @return the mean.
	 * @throws ProbabilityException if the value cannot be computed.
	 */
	public double getMean() throws ProbabilityException;
	
	/**
	 * Returns the median, i.e. the value m so that P(X<=m)=P(X>=m)=1/2.
	 * @return the median.
	 * @throws ProbabilityException if the value cannot be computed.
	 */
	public double getMedian() throws ProbabilityException;
	
	/**
	 * Returns the standard deviation sigma=sqrt(E((X-E(X))^2)).
	 * @return the standard deviation.
	 * @throws ProbabilityException if the value cannot be computed.
	 */
	public double getStandardDeviation() throws ProbabilityException;
	
	/**
	 * Returns the variance sigma^2=E((X-E(X))^2).
	 * @return the variance.
	 * @throws ProbabilityException if the value cannot be computed.
	 */
	public double getVariance() throws ProbabilityException;
	
	/**
	 * Returns the coefficient of variation, i.e. c_v=sigma/mu, where sigma
	 * is the standard deviation and mu the expected value.
	 * @return the standard deviation.
	 * @throws ProbabilityException if the value cannot be computed.
	 */
	public double getCV() throws ProbabilityException;
	
	/**
	 * Returns the domain interval.
	 * @return the domain interval.
	 */
	public RealInterval getDomainInterval();
}
