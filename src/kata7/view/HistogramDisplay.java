package kata7is2.view;

import kata7is2.model.Histogram;

/**
 *
 * @author Pablo Alonso
 */
public interface HistogramDisplay {
    public Histogram histogram();
    public void show(Histogram histogram);
}
