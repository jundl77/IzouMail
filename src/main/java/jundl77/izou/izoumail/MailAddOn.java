package jundl77.izou.izoumail;

import intellimate.izou.activator.Activator;
import intellimate.izou.addon.AddOn;
import intellimate.izou.contentgenerator.ContentGenerator;
import intellimate.izou.events.EventsController;
import intellimate.izou.output.OutputExtension;
import intellimate.izou.output.OutputPlugin;

/**
 * The Mail addOn is a basic mail client for izou, it can send and receive/check emails
 */
public class MailAddOn extends AddOn {
    /**
     * The ID of the addOn
     */
    public static final String ID = MailAddOn.class.getCanonicalName();

    /**
     * Creates a new mail addOn
     */
    public MailAddOn() {
        super(ID);
    }

    @Override
    public void prepare() {
    }

    @Override
    public Activator[] registerActivator() {
        return null;
    }

    @Override
    public ContentGenerator[] registerContentGenerator() {
        return null;
    }

    @Override
    public EventsController[] registerEventController() {
        return null;
    }

    @Override
    public OutputPlugin[] registerOutputPlugin() {
        OutputPlugin[] outputPlugins = new OutputPlugin[1];
        outputPlugins[0] = new MailOutputPlugin(getContext());
        return outputPlugins;
    }

    @Override
    public OutputExtension[] registerOutputExtension() {
        return null;
    }
}
