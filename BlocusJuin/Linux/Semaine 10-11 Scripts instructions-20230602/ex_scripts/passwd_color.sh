#!/bin/bash

# https://www.cyberciti.biz/faq/understanding-etcpasswd-file-format/

IFS=:    # "Internal Field Separator" (IFS) used for word splitting after expansion and to
         # split lines into words with the read builtin command (default value: <space><tab><newline>)
		 # https://bash.cyberciti.biz/guide/$IFS 

while read -r f1 f2 f3 f4 f5 f6 f7   # seven fields from /etc/passwd stored in $f1,$f2...,$f7
do
    echo -ne "User \e[1;32m$f1\e[0;39m"   # bold & green
    echo -ne " uses \e[4;33m$f7\e[0;39m"  # underline & yellow
    echo -ne " shell and stores files in\e[35m $f6 \e[39m"  # magenta
    echo "directory."
done < /etc/passwd

# echo -n : ne passe pas à la ligne après affichage
# echo -e : interprète les 'escape sequences' (caractères précédés de \)
# Font escape sequences:  https://misc.flogisoft.com/bash/tip_colors_and_formatting

