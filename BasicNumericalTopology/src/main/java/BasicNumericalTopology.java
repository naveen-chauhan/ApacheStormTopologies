import bolts.ComputeBolt;
import org.apache.storm.Config;
import org.apache.storm.topology.TopologyBuilder;
import spouts.NumeralSpout;

/**
 * @author naveen.chauhan on 14/06/22
 */
public class BasicNumericalTopology {
    public static void main(String[] args) {
        TopologyBuilder topologyBuilder = new TopologyBuilder();
        topologyBuilder.setSpout("spout", new NumeralSpout(), 1);
        topologyBuilder.setBolt("bolt", new ComputeBolt(), 1).shuffleGrouping("spout");
        Config config = new Config();
        config.put(Config.NIMBUS_HOST, "127.0.0.1");
        config.setDebug(false);

    }
}
