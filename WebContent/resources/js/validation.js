function isAlphabetic(val)
{
    if (val.match(/^[a-zA-Z]+$/))
    {
        return true;
    }
    else
    {
        return false;
    }
}
function isNumeric(sText)

{
    var ValidChars = "0123456789.";
    var IsNumber=true;
    var Char;


    for (i = 0; i < sText.length && IsNumber == true; i++)
    {
        Char = sText.charAt(i);
        if (ValidChars.indexOf(Char) == -1)
        {
            IsNumber = false;
        }
    }
    return IsNumber;

}
function isAlphanumeric(alphane)
{
    var numaric = alphane;
    for(var j=0; j<numaric.length; j++)
    {
        var alphaa = numaric.charAt(j);
        var hh = alphaa.charCodeAt(0);
        if((hh > 47 && hh<58) || (hh > 64 && hh<91) || (hh > 96 && hh<123))
        {
        }
        else	{
            return false;
        }
    }
    return true;
}

function isNotOnlyNumeric(value)
{
    if(isAlphanumeric(value) && !isNumeric(value)){
        return true;
    }else{
        return false;
    }
}