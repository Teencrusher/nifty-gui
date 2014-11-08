/*
 * Copyright (c) 2014, Jens Hohmuth 
 * All rights reserved. 
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are 
 * met: 
 * 
 *  * Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer. 
 *  * Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in the 
 *    documentation and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF 
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package de.lessvoid.nifty.internal.canvas;

import org.jglfont.JGLFont;

import de.lessvoid.nifty.api.NiftyColor;
import de.lessvoid.nifty.api.NiftyFont;
import de.lessvoid.nifty.internal.accessor.NiftyFontAccessor;
import de.lessvoid.nifty.internal.render.batch.BatchManager;

public class CommandText implements Command {
  private final NiftyFont font;
  private final int x;
  private final int y;
  private final String text;

  public CommandText(final NiftyFont font, final int x, final int y, final String text) {
    this.font = font;
    this.x = x;
    this.y = y;
    this.text = text;
  }

  @Override
  public void execute(final BatchManager batchManager, final Context context) {
    JGLFont jglFont = NiftyFontAccessor.getDefault().getJGLFont(font);
    jglFont.setCustomRenderState(batchManager);

    NiftyColor textColor = context.getTextColor();
    jglFont.renderText(
        x, y, text, (float) context.getTextSize(), (float) context.getTextSize(),
        (float) textColor.getRed(),
        (float) textColor.getGreen(),
        (float) textColor.getBlue(),
        (float) textColor.getAlpha());
  }
}
