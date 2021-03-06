package com.gotofinal.autoin.api.cfg.system;

import java.util.Map;

import com.gotofinal.autoin.api.cfg.yaml.DioriteYaml;
import com.gotofinal.autoin.api.cfg.yaml.DioriteYamlConstructor;
import com.gotofinal.autoin.api.utils.reflections.ReflectElement;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.ScalarNode;

public class TemplateYamlConstructor extends DioriteYamlConstructor
{
    private final ClassLoader customClassLoader;

    /**
     * Construct new TemplateYamlConstructor using custom class loader.ł
     *
     * @param customClassLoader other class loader than normal.
     */
    public TemplateYamlConstructor(final ClassLoader customClassLoader)
    {
        this.customClassLoader = customClassLoader;
    }

    /**
     * Construct new default TemplateYamlConstructor.
     */
    public TemplateYamlConstructor()
    {
        this.customClassLoader = null;
    }

    private static class FieldCounter
    {
        private final Template<?>              template;
        private final Map<String, ConfigField> fields;

        private FieldCounter(final Template<?> template)
        {
            this.template = template;
            this.fields = template.getFieldsNameMap();
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("template", this.template).append("fields", this.fields.keySet()).toString();
        }
    }

    @Override
    protected Class<?> getClassForName(final String name) throws ClassNotFoundException
    {
        if (this.customClassLoader != null)
        {
            return Class.forName(name, true, this.customClassLoader);
        }
        return Class.forName(name);
    }

    {
        this.yamlClassConstructors.put(NodeId.mapping, new TemplateConstructMapping());
    }

    protected class TemplateConstructMapping extends DioriteConstructMapping
    {

        @Override
        protected Object constructJavaBean2ndStep(final MappingNode node, Object object)
        {
            final Class<?> beanType = node.getType();
            final Template<?> template = TemplateCreator.getTemplate(beanType, false);
            final FieldCounter counter;
            if (template != null)
            {
                counter = new FieldCounter(template);
                node.getValue().stream().filter(nodeTuple -> nodeTuple.getKeyNode() instanceof ScalarNode).forEach(nodeTuple -> counter.fields.remove(((ScalarNode) nodeTuple.getKeyNode()).getValue()));
            }
            else
            {
                counter = null;
            }
            object = super.constructJavaBean2ndStep(node, object);
            if (counter != null)
            {
                final Map<ConfigField, ReflectElement<?>> fields = template.getFields();
                for (final ConfigField field : counter.fields.values())
                {
                    if (! field.hasDefaultValue())
                    {
                        continue;
                    }
                    final ReflectElement<?> element = fields.get(field);
                    if (element != null)
                    {
                        element.set(object, field.getDefaultValue());
                    }
                }
            }
            return object;
        }
    }

    /**
     * @return snake yaml instance using DioriteYaml constructor extension, used by all templates.
     */
    public static DioriteYaml getInstance()
    {
        return new DioriteYaml(new TemplateYamlConstructor());
    }

    /**
     * @param customClassLoader other class loader than normal.
     *
     * @return snake yaml instance using DioriteYaml constructor extension, used by all templates.
     */
    public static DioriteYaml getInstance(final ClassLoader customClassLoader)
    {
        return new DioriteYaml(new TemplateYamlConstructor(customClassLoader));
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("customClassLoader", this.customClassLoader).toString();
    }
}
