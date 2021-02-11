<?php

namespace Maths
{
    function sqrt($val)
    {
        if (!is_numeric($val))
            return NAN;
        elseif ($val >= 0)
            return \sqrt($val);
        else
            return -(\sqrt(abs($val)));
    }
    /*TESTS*/
}
?>