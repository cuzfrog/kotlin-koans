package ii_collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import util.JavaCode;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class _24_JavaCode extends JavaCode {
    /**
     * Find the largest group of String with the same length.
     * @param collection of Strings
     * @return a group of Strings that have the A length, most Strings in collection have A length.
     */
    public Collection<String> doSomethingStrangeWithCollection(Collection<String> collection) {
        Map<Integer, List<String>> groupsByLength = Maps.newHashMap();
        for (String s : collection) {
            List<String> strings = groupsByLength.computeIfAbsent(
                    s.length(), k -> Lists.newArrayList()
            );
            strings.add(s);
        }

        int maximumSizeOfGroup = 0;
        for (List<String> group : groupsByLength.values()) {
            if (group.size() > maximumSizeOfGroup) {
                maximumSizeOfGroup = group.size();
            }
        }

        for (List<String> group : groupsByLength.values()) {
            if (group.size() == maximumSizeOfGroup) {
                return group;
            }
        }
        return null;
    }
}
