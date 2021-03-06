package com.gotofinal.autoin.api.utils.collections.maps;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import com.gotofinal.autoin.api.utils.collections.comparators.ByValueComparator;

public class ByValueSortingConcurrentSkipListMap<K extends Comparable<K>, V extends Comparable<V>> extends ConcurrentSkipListMap<K, V>
{
    private static final long serialVersionUID = 0;
    protected final ByValueComparator<K, V> comparator;

    public ByValueSortingConcurrentSkipListMap(final ByValueComparator<K, V> comparator)
    {
        super(comparator);
        this.comparator = comparator;
    }

    @Override
    public void putAll(final Map<? extends K, ? extends V> map)
    {
        this.comparator.getMap().putAll(map);
        super.putAll(map);
    }

    @Override
    public String toString()
    {
        return "ByValueSortingConcurrentSkipListMap{" +
                       "comparator=" + this.comparator +
                       "} " + super.toString();
    }

    @Override
    public V put(final K key, final V value)
    {
        this.comparator.getMap().put(key, value);
        return super.put(key, value);
    }
}
