package br.dev.techtalk.domain.constants;

import br.dev.techtalk.domain.enumeration.BookNodesEnum;

import java.util.Arrays;
import java.util.List;

public class BookGraphConst {

    public static final List<String> PUBLIC_NODES = Arrays.asList(
            BookNodesEnum.BOOK.getValue(),
            BookNodesEnum.PUBLISHER.getValue(),
            BookNodesEnum.AUTHORS.getValue());

}
