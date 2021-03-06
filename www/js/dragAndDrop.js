/**
 * Created by JetBrains RubyMine.
 * User: Brian
 * Date: 3/10/12
 * Time: 8:29 PM
 * To change this template use File | Settings | File Templates.
 */

var _startX = 0;            // mouse starting positions
var _startY = 0;
var _offsetX = 0;           // current element offset
var _offsetY = 0;
var _dragElement;           // needs to be passed from OnMouseDown to OnMouseMove
var _oldZIndex = 0;         // we temporarily increase the z-index during drag

var _topBoundry = 5;
var _bottomBoundry = 415;
var _leftBoundry = 5;
var _rightBoundry = 715;

var _tableWidth = 70;

function InitDragDrop()
{
    document.onmousedown = onMouseDown;
    document.onmouseup = onMouseUp;
	
	var container = document.getElementById('pageContainer');
    _leftBoundry = container.offsetLeft;
    _rightBoundry = container.offsetLeft+container.offsetWidth;
    _topBoundry = container.offsetTop;
    _bottomBoundry = container.offsetTop+container.offsetHeight;
}

function onMouseDown(e)
{
    //console.log(onMouseDown);
    console.log(e);

    // IE is retarded and doesn't pass the event object
    if (e == null) e = window.event;

    // IE uses srcElement, others use target
    var target = e.target != null ? e.target : e.srcElement;

    // for IE, left click == 1  Firefox, left click == 0
    if ((e.button == 1 && window.event != null || e.button == 0) && target.className == 'drag')
    {
        // grab the mouse position
        _startX = e.clientX;
        _startY = e.clientY;

        // grab the clicked element's position
        _offsetX = ExtractNumber(target.style.left);
        _offsetY = ExtractNumber(target.style.top);

        // bring the clicked element to the front while it is being dragged
        _oldZIndex = target.style.zIndex;
        target.style.zIndex = 10000;

        // we need to access the element in OnMouseMove
        _dragElement = target;

        // tell our code to start moving the element with the mouse
        document.onmousemove = onMouseMove;

        // cancel out any text selections
        document.body.focus();

        // prevent text selection in IE
        document.onselectstart = function () { return false; };
        // prevent IE from trying to drag an image
        target.ondragstart = function() { return false; };

        // prevent text selection (except IE)
        return false;
    }
}

function onMouseUp(e)
{
    if (_dragElement != null)
    {
        _dragElement.style.zIndex = _oldZIndex;

        // we're done with these events until the next OnMouseDown
        document.onmousemove = null;
        document.onselectstart = null;
        _dragElement.ondragstart = null;

        // this is how we know we're not dragging
        _dragElement = null;
    }
}

function onMouseMove(e)
{
    if (e == null)
        var e = window.event;

    // this is the actual "drag code"
	var newLeft = _offsetX + e.clientX - _startX;
	var newTop = _offsetY + e.clientY - _startY;
	
	if(newLeft < _leftBoundry) newLeft = _leftBoundry;
    if(newLeft > _rightBoundry-_tableWidth) {
        newLeft = _rightBoundry-_tableWidth; 
    }
    if(newTop < _topBoundry) newTop = _topBoundry;
    if(newTop > _bottomBoundry-_tableWidth) newTop = _bottomBoundry-_tableWidth;
    
    _dragElement.style.left = newLeft + 'px';
    _dragElement.style.top = newTop + 'px';
}

function ExtractNumber(value)
{
    var n = parseInt(value);

    return n == null || isNaN(n) ? 0 : n;
}

// this is simply a shortcut for the eyes and fingers
function $(id)
{
    return document.getElementById(id);
}


