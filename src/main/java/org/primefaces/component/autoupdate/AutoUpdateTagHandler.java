/**
 * Copyright 2009-2019 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.component.autoupdate;

import java.io.IOException;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.*;

public class AutoUpdateTagHandler extends TagHandler {

    private final TagAttribute disabledAttribute;

    public AutoUpdateTagHandler(TagConfig tagConfig) {
        super(tagConfig);

        disabledAttribute = getAttribute("disabled");
    }

    @Override
    public void apply(FaceletContext faceletContext, UIComponent parent) throws IOException, FacesException, FaceletException, ELException {

        boolean disabled = false;
        if (disabledAttribute != null) {
            disabled = disabledAttribute.getBoolean(faceletContext);
        }

        AutoUpdateListener.subscribe(parent, disabled);
    }
}
