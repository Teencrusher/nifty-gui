package de.lessvoid.nifty.examples.dragndrop;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyIdCreator;
import de.lessvoid.nifty.controls.dynamic.attributes.ControlAttributes;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen; 

public class CreateWindowControl extends ControlAttributes {
  public CreateWindowControl() {
    setId(NiftyIdCreator.generate());
    setName("window");
  }

  public CreateWindowControl(final String id) {
    setId(id);
    setName("window");
  }

  public WindowControl create(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    nifty.addControl(screen, parent, getStandardControl());
    nifty.addControlsWithoutStartScreen();
    return parent.findControl(attributes.get("id"), WindowControl.class);
  }
}
