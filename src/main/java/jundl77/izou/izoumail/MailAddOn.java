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
        return new Activator[0];
    }

    @Override
    public ContentGenerator[] registerContentGenerator() {
        return new ContentGenerator[0];
    }

    @Override
    public EventsController[] registerEventController() {
        return new EventsController[0];
    }

    @Override
    public OutputPlugin[] registerOutputPlugin() {
        return new OutputPlugin[0];
    }

    @Override
    public OutputExtension[] registerOutputExtension() {
        return new OutputExtension[0];
    }
}
