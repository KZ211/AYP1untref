/*
<<<<<<< HEAD
 * Copyright (c) 2013, 2020, Oracle and/or its affiliates. All rights reserved.
=======
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

var moduleSearchIndex;
var packageSearchIndex;
var typeSearchIndex;
var memberSearchIndex;
var tagSearchIndex;
function loadScripts(doc, tag) {
<<<<<<< HEAD
    createElem(doc, tag, 'search.js');

    createElem(doc, tag, 'module-search-index.js');
    createElem(doc, tag, 'package-search-index.js');
    createElem(doc, tag, 'type-search-index.js');
    createElem(doc, tag, 'member-search-index.js');
    createElem(doc, tag, 'tag-search-index.js');
=======
    createElem(doc, tag, 'jquery/jszip/dist/jszip.js');
    createElem(doc, tag, 'jquery/jszip-utils/dist/jszip-utils.js');
    if (window.navigator.userAgent.indexOf('MSIE ') > 0 || window.navigator.userAgent.indexOf('Trident/') > 0 ||
            window.navigator.userAgent.indexOf('Edge/') > 0) {
        createElem(doc, tag, 'jquery/jszip-utils/dist/jszip-utils-ie.js');
    }
    createElem(doc, tag, 'search.js');

    $.get(pathtoroot + "module-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "module-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("module-search-index.json").async("text").then(function(content){
                            moduleSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "package-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "package-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("package-search-index.json").async("text").then(function(content){
                            packageSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "type-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "type-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("type-search-index.json").async("text").then(function(content){
                            typeSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "member-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "member-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("member-search-index.json").async("text").then(function(content){
                            memberSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "tag-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "tag-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("tag-search-index.json").async("text").then(function(content){
                            tagSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    if (!moduleSearchIndex) {
        createElem(doc, tag, 'module-search-index.js');
    }
    if (!packageSearchIndex) {
        createElem(doc, tag, 'package-search-index.js');
    }
    if (!typeSearchIndex) {
        createElem(doc, tag, 'type-search-index.js');
    }
    if (!memberSearchIndex) {
        createElem(doc, tag, 'member-search-index.js');
    }
    if (!tagSearchIndex) {
        createElem(doc, tag, 'tag-search-index.js');
    }
    $(window).resize(function() {
        $('.navPadding').css('padding-top', $('.fixedNav').css("height"));
    });
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
}

function createElem(doc, tag, path) {
    var script = doc.createElement(tag);
    var scriptElement = doc.getElementsByTagName(tag)[0];
    script.src = pathtoroot + path;
    scriptElement.parentNode.insertBefore(script, scriptElement);
}

<<<<<<< HEAD
function show(tableId, selected, columns) {
    if (tableId !== selected) {
        document.querySelectorAll('div.' + tableId + ':not(.' + selected + ')')
            .forEach(function(elem) {
                elem.style.display = 'none';
            });
    }
    document.querySelectorAll('div.' + selected)
        .forEach(function(elem, index) {
            elem.style.display = '';
            var isEvenRow = index % (columns * 2) < columns;
            elem.classList.remove(isEvenRow ? oddRowColor : evenRowColor);
            elem.classList.add(isEvenRow ? evenRowColor : oddRowColor);
        });
    updateTabs(tableId, selected);
}

function updateTabs(tableId, selected) {
    document.querySelector('div#' + tableId +' .summary-table')
        .setAttribute('aria-labelledby', selected);
    document.querySelectorAll('button[id^="' + tableId + '"]')
        .forEach(function(tab, index) {
            if (selected === tab.id || (tableId === selected && index === 0)) {
                tab.className = activeTableTab;
                tab.setAttribute('aria-selected', true);
                tab.setAttribute('tabindex',0);
            } else {
                tab.className = tableTab;
                tab.setAttribute('aria-selected', false);
                tab.setAttribute('tabindex',-1);
            }
        });
}

function switchTab(e) {
    var selected = document.querySelector('[aria-selected=true]');
    if (selected) {
        if ((e.keyCode === 37 || e.keyCode === 38) && selected.previousSibling) {
            // left or up arrow key pressed: move focus to previous tab
            selected.previousSibling.click();
            selected.previousSibling.focus();
            e.preventDefault();
        } else if ((e.keyCode === 39 || e.keyCode === 40) && selected.nextSibling) {
            // right or down arrow key pressed: move focus to next tab
            selected.nextSibling.click();
            selected.nextSibling.focus();
            e.preventDefault();
=======
function show(type) {
    count = 0;
    for (var key in data) {
        var row = document.getElementById(key);
        if ((data[key] &  type) !== 0) {
            row.style.display = '';
            row.className = (count++ % 2) ? rowColor : altColor;
        }
        else
            row.style.display = 'none';
    }
    updateTabs(type);
}

function updateTabs(type) {
    for (var value in tabs) {
        var sNode = document.getElementById(tabs[value][0]);
        var spanNode = sNode.firstChild;
        if (value == type) {
            sNode.className = activeTableTab;
            spanNode.innerHTML = tabs[value][1];
        }
        else {
            sNode.className = tableTab;
            spanNode.innerHTML = "<a href=\"javascript:show("+ value + ");\">" + tabs[value][1] + "</a>";
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
        }
    }
}

<<<<<<< HEAD
var updateSearchResults = function() {};

function indexFilesLoaded() {
    return moduleSearchIndex
        && packageSearchIndex
        && typeSearchIndex
        && memberSearchIndex
        && tagSearchIndex;
}

// Workaround for scroll position not being included in browser history (8249133)
document.addEventListener("DOMContentLoaded", function(e) {
    var contentDiv = document.querySelector("div.flex-content");
    window.addEventListener("popstate", function(e) {
        if (e.state !== null) {
            contentDiv.scrollTop = e.state;
        }
    });
    window.addEventListener("hashchange", function(e) {
        history.replaceState(contentDiv.scrollTop, document.title);
    });
    contentDiv.addEventListener("scroll", function(e) {
        var timeoutID;
        if (!timeoutID) {
            timeoutID = setTimeout(function() {
                history.replaceState(contentDiv.scrollTop, document.title);
                timeoutID = null;
            }, 100);
        }
    });
    if (!location.hash) {
        history.replaceState(contentDiv.scrollTop, document.title);
    }
});
=======
function updateModuleFrame(pFrame, cFrame) {
    top.packageFrame.location = pFrame;
    top.classFrame.location = cFrame;
}
>>>>>>> 6855468c6d3bb8095fcb43895b0ed150c7c38a74
