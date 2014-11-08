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

import de.lessvoid.nifty.api.NiftyColor;
import de.lessvoid.nifty.api.NiftyImage;
import de.lessvoid.nifty.internal.InternalNiftyImage;
import de.lessvoid.nifty.internal.accessor.NiftyImageAccessor;
import de.lessvoid.nifty.internal.math.Mat4;
import de.lessvoid.nifty.internal.render.batch.BatchManager;

public class CommandImage implements Command {
  private final int x;
  private final int y;
  private final NiftyImage image;

  public CommandImage(final int x, final int y, final NiftyImage image) {
    this.x = x;
    this.y = y;
    this.image = image;
  }

  @Override
  public void execute(final BatchManager batchManager, final Context context) {
    InternalNiftyImage internalImage = NiftyImageAccessor.getDefault().getInternalNiftyImage(image);
    Mat4 local = Mat4.mul(context.getTransform(), Mat4.createTranslate(x, y, 0.0f));
    batchManager.addTextureQuad(internalImage.getTexture(), local, NiftyColor.WHITE());
  }
}
