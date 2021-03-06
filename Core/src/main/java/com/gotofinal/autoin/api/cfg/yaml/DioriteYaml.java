package com.gotofinal.autoin.api.cfg.yaml;

import org.yaml.snakeyaml.Yaml;

public class DioriteYaml extends Yaml
{
    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     */
    public DioriteYaml()
    {
        this(new DioriteYamlConstructor(), new DioriteYamlRepresenter(), new DioriteYamlDumperOptions(), new DioriteYamlResolver());
    }

    /**
     * Create Yaml instance.
     *
     * @param dumperOptions DioriteYamlDumperOptions to configure outgoing objects
     */
    public DioriteYaml(final DioriteYamlDumperOptions dumperOptions)
    {
        this(new DioriteYamlConstructor(), new DioriteYamlRepresenter(), dumperOptions);
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param representer DioriteYamlRepresenter to emit outgoing objects
     */
    public DioriteYaml(final DioriteYamlRepresenter representer)
    {
        this(new DioriteYamlConstructor(), representer);
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param constructor BaseDioriteYamlConstructor to construct incoming documents
     */
    public DioriteYaml(final DioriteYamlConstructor constructor)
    {
        this(constructor, new DioriteYamlRepresenter());
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param constructor BaseDioriteYamlConstructor to construct incoming documents
     * @param representer DioriteYamlRepresenter to emit outgoing objects
     */
    public DioriteYaml(final DioriteYamlConstructor constructor, final DioriteYamlRepresenter representer)
    {
        this(constructor, representer, new DioriteYamlDumperOptions());
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param representer   DioriteYamlRepresenter to emit outgoing objects
     * @param dumperOptions DioriteYamlDumperOptions to configure outgoing objects
     */
    public DioriteYaml(final DioriteYamlRepresenter representer, final DioriteYamlDumperOptions dumperOptions)
    {
        this(new DioriteYamlConstructor(), representer, dumperOptions, new DioriteYamlResolver());
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param constructor   BaseDioriteYamlConstructor to construct incoming documents
     * @param representer   DioriteYamlRepresenter to emit outgoing objects
     * @param dumperOptions DioriteYamlDumperOptions to configure outgoing objects
     */
    public DioriteYaml(final DioriteYamlConstructor constructor, final DioriteYamlRepresenter representer, final DioriteYamlDumperOptions dumperOptions)
    {
        this(constructor, representer, dumperOptions, new DioriteYamlResolver());
    }

    /**
     * Create Yaml instance. It is safe to create a few instances and use them
     * in different Threads.
     *
     * @param constructor   BaseConstructor to construct incoming documents
     * @param representer   Representer to emit outgoing objects
     * @param dumperOptions DumperOptions to configure outgoing objects
     * @param resolver      Resolver to detect implicit type
     */
    public DioriteYaml(final DioriteYamlConstructor constructor, final DioriteYamlRepresenter representer, final DioriteYamlDumperOptions dumperOptions, final DioriteYamlResolver resolver)
    {
        super(constructor, representer, dumperOptions, resolver);
    }

    public DioriteYamlDumperOptions getDumperOptions()
    {
        return (DioriteYamlDumperOptions) this.dumperOptions;
    }

    public void setDumperOptions(final DioriteYamlDumperOptions dumperOptions)
    {
        this.dumperOptions = dumperOptions;
    }

    public DioriteYamlRepresenter getRepresenter()
    {
        return (DioriteYamlRepresenter) this.representer;
    }

    public void setRepresenter(final DioriteYamlRepresenter representer)
    {
        this.representer = representer;
    }

    public DioriteYamlConstructor getConstructor()
    {
        return (DioriteYamlConstructor) this.constructor;
    }

    public void setConstructor(final DioriteYamlConstructor constructor)
    {
        this.constructor = constructor;
    }

    public DioriteYamlResolver getResolver()
    {
        return (DioriteYamlResolver) this.resolver;
    }
}
