package com.gotofinal.autoin.api.cfg.system.elements;

import java.io.IOException;

import com.gotofinal.autoin.api.cfg.system.CfgEntryData;
import com.gotofinal.autoin.api.cfg.system.Template;
import com.gotofinal.autoin.api.cfg.system.TemplateCreator;

/**
 * Last template handler, trying get template for unknown object, or change it to string.
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class DefaultTemplateElement extends TemplateElement<Object>
{
    /**
     * Instance of template to direct-use.
     */
    public static final DefaultTemplateElement INSTANCE = new DefaultTemplateElement();

    /**
     * Construct new default template handler.
     */
    public DefaultTemplateElement()
    {
        super(Object.class, obj -> obj, c -> true);
    }

    @Override
    protected Object convertDefault0(final Object def, final Class<?> fieldType)
    {
        return def;
    }

    @Override
    protected void appendValue(final Appendable writer, final CfgEntryData field, final Object source, final Object element, final int level, final ElementPlace elementPlace) throws IOException
    {
        final Template template = TemplateCreator.getTemplate(element.getClass(), false);
        if (template != null)
        {
            writer.append('\n');
            template.dump(writer, element, level + 1, false, elementPlace);
        }
        else
        {
            StringTemplateElement.INSTANCE.appendValue(writer, field, source, StringTemplateElement.INSTANCE.validateType(element), level, elementPlace);
        }
    }

}
